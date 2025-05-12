package web.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("area")
@ApplicationScoped
public class Area implements Serializable, AreaMBean {
    private double area = 0;

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public void updateStats(double r) {
        area = ((Math.PI * Math.pow(r / 2, 2) / 4) + ((r * r/2) / 2) + (r * r/2));
    }

}