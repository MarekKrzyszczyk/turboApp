package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.CustomMapper;
import com.turbo.turbochargerswebservices.model.dto.OrderDto;
import com.turbo.turbochargerswebservices.model.dto.UserDto;
import com.turbo.turbochargerswebservices.model.entity.Order;
import com.turbo.turbochargerswebservices.model.entity.SequencePattern;
import com.turbo.turbochargerswebservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractBaseServiceImpl<Order, Long> implements OrderService {

    private final OrderRepository orderRepository;
    private final SequencePatternService sequencePatternService;
    private final CustomMapper customMapper;
    private static final String ENTITY = "order";
    private static final String PREFIX = "ZAM";

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, SequencePatternService sequencePatternService, CustomMapper customMapper) {
        super(orderRepository);
        this.sequencePatternService = sequencePatternService;
        this.orderRepository = orderRepository;
        this.customMapper = customMapper;
    }

    @Override
    public List<OrderDto> listAllOrders() {
        return customMapper.mapOrders(orderRepository.findAll());
    }

    @Override
    public void setDeletedAsTrue(Long id) {
        Optional<Order> optOrder = orderRepository.findById(id);
        if (optOrder.isPresent()) {
            Order deletedOrder = optOrder.get();
            deletedOrder.setDeleted(true);
            orderRepository.save(deletedOrder);
        }
    }

    @Override
    public Order create(Order order) {
        SequencePattern orderNumberPattern;
        orderNumberPattern = sequencePatternService.findByYearAndMonthAndEntity(LocalDate.now(), ENTITY);
        if (orderNumberPattern == null) {
            orderNumberPattern = sequencePatternService.create(ENTITY, PREFIX);
        }
        String orderNumber = sequencePatternService.getSequenceNumber(orderNumberPattern);
        order.setOrderNumber(orderNumber);
        sequencePatternService.increaseCurrentNumber(orderNumberPattern);
        return orderRepository.save(order);
    }
}
