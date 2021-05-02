package com.turbo.turbochargerswebservices.service;

import com.turbo.turbochargerswebservices.model.dto.order.OrderDto;
import com.turbo.turbochargerswebservices.model.dto.order.OrderMapper;
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
public class OrderServiceImpl extends AbstractBaseServiceImpl<Order, OrderDto, Long> implements OrderService {

    private final OrderRepository orderRepository;
    private final SequencePatternService sequencePatternService;
    private final OrderMapper orderMapper;
    private static final String ENTITY = "order";
    private static final String PREFIX = "ZAM";

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, SequencePatternService sequencePatternService, OrderMapper orderMapper) {
        super(orderRepository, orderMapper);
        this.sequencePatternService = sequencePatternService;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDto> listAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.mapToDtoList(orders);
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
    public OrderDto create(OrderDto orderDto) {
        SequencePattern orderNumberPattern;
        orderNumberPattern = sequencePatternService.findByYearAndMonthAndEntity(LocalDate.now(), ENTITY);
        if (orderNumberPattern == null) {
            orderNumberPattern = sequencePatternService.create(ENTITY, PREFIX);
        }
        String orderNumber = sequencePatternService.getSequenceNumber(orderNumberPattern);
        orderDto.setOrderNumber(orderNumber);
        sequencePatternService.increaseCurrentNumber(orderNumberPattern);
        return save(orderDto);
    }
}
