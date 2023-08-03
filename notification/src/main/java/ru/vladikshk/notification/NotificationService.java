package ru.vladikshk.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vladikshk.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sender("vladikshk")
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .build());
    }
}
