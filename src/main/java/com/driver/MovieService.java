package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieService {
	
	@Autowired
	MovieRepository Movierepo;

}
