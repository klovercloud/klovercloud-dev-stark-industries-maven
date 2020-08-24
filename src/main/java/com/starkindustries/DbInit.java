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
	
//    @PostConstruct
//    private void postConstruct() {
//    	ArrayList<String> missions=new ArrayList();
//    	missions.add("Civil war");
//    	missions.add("Infinity war");
//        Avengers tonyStark = new Avengers("101", "Tony Stark", "Chairman", "tonystark.jpg", missions);
//        avengersRepo.save(tonyStark);
//        
//        
//    	missions=new ArrayList();
//    	missions.add("Civil war");
//    	missions.add("Infinity war");
//        Avengers  steve = new Avengers("102", "Steve Rogers", "Vice Chairman", "steve.jpg", missions);
//        avengersRepo.save(steve);
//    }
	
}
