package com.starkindustries;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.starkindustries.data.Avengers;
import com.starkindustries.data.repository.AvengersRepository;

@Component
public class DbInit {

	@Autowired
	AvengersRepository avengersRepo;
	
    @PostConstruct
    private void postConstruct() {
    	ArrayList<String> missions=new ArrayList();
    	missions.add("1");
        Avengers tonyStark = new Avengers("1", "101", "Tony Stark", "Chairman", "tonystark.jpg", missions);
        avengersRepo.save(tonyStark);
    }
	
}
