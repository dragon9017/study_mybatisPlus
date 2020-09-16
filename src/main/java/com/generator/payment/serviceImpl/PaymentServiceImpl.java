package com.generator.payment.serviceImpl;

import com.generator.payment.entity.Payment;
import com.generator.payment.mapper.PaymentMapper;
import com.generator.payment.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lby
 * @since 2020-09-16
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
