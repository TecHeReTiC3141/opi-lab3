package web.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import javax.management.*;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@Named("results")
@ApplicationScoped
public class Results implements Serializable, NotificationBroadcaster, ResultsMBean {
    private int sequenceNumber = 0;

    private final AtomicInteger totalAttempts = new AtomicInteger();
    private final AtomicInteger totalMisses = new AtomicInteger();

    private final NotificationBroadcasterSupport broadcaster = new NotificationBroadcasterSupport();

    @Override
    public int getTotalAttempts() {
        return totalAttempts.get();
    }

    @Override
    public int getTotalMisses() {
        return totalMisses.get();
    }

    @Override
    public void updateStats(boolean hit) {
        totalAttempts.incrementAndGet();
        if (!hit) {
            totalMisses.incrementAndGet();
        }

        if (totalAttempts.get() % 5 == 0) {
            broadcaster.sendNotification(new Notification(
                    "Total dots count is multiple of 5",
                    getClass().getSimpleName(),
                    sequenceNumber++,
                    "The total count of user-set dots is now multiple of 5!"
            ));
        }
    }

    @Override
    public void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback) throws IllegalArgumentException {
        broadcaster.addNotificationListener(listener, filter, handback);
    }

    @Override
    public void removeNotificationListener(NotificationListener listener) throws ListenerNotFoundException {
        broadcaster.removeNotificationListener(listener);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "Miss notification";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[] { info };
    }
}
