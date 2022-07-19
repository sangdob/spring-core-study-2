package hello.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderItem(String itemId) {
        log.info("[orderService] start {}", itemId);
        orderRepository.save(itemId);
    }

    @Around("allOrder() && allService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            log.info("[트랜잭션 start] {}", joinPoint.getSignature());
            Object result = joinPoint.getSignature();
            log.info("[트랜잭션 commit] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("[트랜잭션 rollBack] {}", joinPoint.getSignature());
            throw e;
        }finally {
            log.info("[리소스 릴리즈] {}",joinPoint.getSignature());
        }
    }
}
