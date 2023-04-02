package com.yllu.common.tracking.service;

import com.yllu.common.domain.Vendor;
import com.yllu.common.tracking.TestTracker;
import com.yllu.common.tracking.TestTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestTrackerService {

    private TestTrackerRepository testTrackerRepository;

    public String initiateTestTracker(Vendor vendor){
        new TestTracker(vendor);
        return testTrackerRepository.save(new TestTracker(vendor)).getId();
    }
}
