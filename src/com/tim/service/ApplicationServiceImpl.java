package com.tim.service;

import com.tim.entity.Application;
import com.tim.exception.ApplicationNotFoundException;
import com.tim.model.ApplicationRequest;
import com.tim.model.ApplicationVO;
import com.tim.repository.ApplicationRepository;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Application service implementation Author
 */
@Service
//@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

	
	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired

	/*
	 * public ApplicationServiceImpl(ApplicationContext applicationContext) {
	 * this.applicationContext = applicationContext; }
	 */

	// @PreAuthorize("hasRole('ADMIN')")
	@Override
	public List<ApplicationVO> findAll() {
		// log.info("Inside ApplicationServiceImpl.findAll");
		List<Application> applications = applicationRepository.findAll();
		// log.info("Find all application response: {}", applications);
		List<ApplicationVO> applicationVOS = applications.parallelStream().map(application -> {
			ApplicationVO applicationVO = new ApplicationVO();
			applicationVO.setApplicationId(application.getApplicationId());
			applicationVO.setApplicationName(application.getApplicationName());
			applicationVO.setOwner(application.getOwner());
			applicationVO.setDescription(application.getDescription());
			return applicationVO;
		}).collect(Collectors.toList());
		return (applicationVOS);

	}

	/* *//**
			 * Get application by id
			 *
			 */
	/*
	 * @Cacheable("findById")
	 * 
	 * @Async("asyncBean")
	 * 
	 * @Override public CompletableFuture<ApplicationVO> getApplicationId(long id)
	 * throws ApplicationNotFoundException, InterruptedException {
	 * log.info("Inside ApplicationServiceImpl.getApplicationbyId, id:{}", id);
	 * Thread.sleep(6000); if(id<=0){
	 * log.info("Invalid application id, application Id:{id}", id); throw new
	 * ApplicationNotFoundException("invalid application id"); }
	 * Optional<Application> application = applicationRepository.findById(id);
	 * if(!application.isPresent()){
	 * log.info("No record found for application id:{}", id); throw new
	 * ApplicationNotFoundException("No record found for application id"); }
	 * ApplicationVO applicationVO = new ApplicationVO();
	 * applicationVO.setApplicationId(application.get().getApplicationId());
	 * applicationVO.setDescription(application.get().getDescription());
	 * applicationVO.setApplicationName(application.get().getApplicationName());
	 * applicationVO.setOwner(application.get().getOwner()); return
	 * CompletableFuture.completedFuture(applicationVO); }
	 */
	  
	  @Override 
	  public ApplicationVO getAppId(long id) throws ApplicationNotFoundException, InterruptedException {
	//  log.info("Inside ApplicationServiceImpl.getApplicationbyId, id:{}", id);
	 // Thread.sleep(6000); 
		  if(id<=0){
	 // log.info("Invalid application id, application Id:{id}", id); 
			  throw new ApplicationNotFoundException("invalid application id"); }
	  Optional<Application> application = applicationRepository.findById(id);
	  if(!application.isPresent()){
	  //log.info("No record found for application id:{}", id); 
		  throw new ApplicationNotFoundException("No record found for application id"); }
	  ApplicationVO applicationVO = new ApplicationVO();
	  applicationVO.setApplicationId(application.get().getApplicationId());
	  applicationVO.setDescription(application.get().getDescription());
	  applicationVO.setApplicationName(application.get().getApplicationName());
	  applicationVO.setOwner(application.get().getOwner()); return (applicationVO);
	  }
	  
	 /**
		 * Get application by name in custom JPA
		 * 
		 * @param name
		 * @return
		 */
	/*
	 * @Cacheable("findByName")
	 * 
	 * @Async("asyncBean")
	 * 
	 * @Override public CompletableFuture<ApplicationVO> findByName(String name)
	 * throws ApplicationNotFoundException, InterruptedException {
	 * log.info("Input to ApplicationServiceImpl.FindByName, name:{} ", name);
	 * Thread.sleep(6000); ApplicationVO applicationVO = null; if(name==null){
	 * log.info("Invalid application name, application nameId:{name}", name); throw
	 * new ApplicationNotFoundException("invalid application name"); }
	 * Optional<Application> application =
	 * applicationRepository.findByApplicationName(name);
	 * if(application.isPresent()){
	 * log.info("Find application by name response: {}", application.get());
	 * applicationVO = new ApplicationVO();
	 * applicationVO.setApplicationId(application.get().getApplicationId());
	 * applicationVO.setDescription(application.get().getDescription());
	 * applicationVO.setApplicationName(application.get().getApplicationName());
	 * applicationVO.setOwner(application.get().getOwner()); } return
	 * CompletableFuture.completedFuture(applicationVO); }
	 * 
	 * @Override public ApplicationVO findGetByName(String name) throws
	 * ApplicationNotFoundException, InterruptedException {
	 * log.info("Input to ApplicationServiceImpl.FindByName, name:{} ", name);
	 * Thread.sleep(6000); ApplicationVO applicationVO = null; if(name==null){
	 * log.info("Invalid application name, application nameId:{name}", name); throw
	 * new ApplicationNotFoundException("invalid application name"); }
	 * Optional<Application> application =
	 * applicationRepository.findByApplicationName(name);
	 * if(application.isPresent()){
	 * log.info("Find application by name response: {}", application.get());
	 * applicationVO = new ApplicationVO();
	 * applicationVO.setApplicationId(application.get().getApplicationId());
	 * applicationVO.setDescription(application.get().getDescription());
	 * applicationVO.setApplicationName(application.get().getApplicationName());
	 * applicationVO.setOwner(application.get().getOwner()); } return
	 * (applicationVO); }
	 * 
	 * 
	 * public ApplicationVO findByNameApp(String name, long id) throws
	 * ApplicationNotFoundException, InterruptedException {
	 * log.info("Input to ApplicationServiceImpl.FindByName, name:{} ", name, id);
	 * ApplicationVO applicationVO = null; if(name==null){
	 * log.info("Invalid application name, application nameId:{name}", name, id);
	 * throw new ApplicationNotFoundException("invalid application name"); }
	 * Optional<Application> application = applicationRepository.findByAppName(name,
	 * id); if(application.isPresent()){
	 * log.info("Find application by name response: {}", application.get());
	 * applicationVO = new ApplicationVO();
	 * applicationVO.setApplicationId(application.get().getApplicationId());
	 * applicationVO.setDescription(application.get().getDescription());
	 * applicationVO.setApplicationName(application.get().getApplicationName());
	 * applicationVO.setOwner(application.get().getOwner()); } return
	 * (applicationVO); }
	 * 
	 *//**
		 * Save application details
		 * 
		 * @param applicationRequest
		 * @return
		 * @throws ApplicationNotFoundException
		 */
	
	
	 // @PreAuthorize("hasRole('USER')") 
	  public ApplicationVO save(ApplicationRequest applicationRequest) throws ApplicationNotFoundException { 
		  //log.info("Inside the ApplicationServiceImpl.save method and params, applicationRequest:{}" , applicationRequest);
	  
	  if(applicationRequest == null){ 
		//  log.info("Invalid application request");
	  throw new ApplicationNotFoundException("Invalid application request"); 
	  } 
	  //applicationrequest convert into application entity 
	  Application application = new Application();
	  if(applicationRequest.getApplicationId() > 0){
	  application.setApplicationId(applicationRequest.getApplicationId()); }
	  if(applicationRequest.getApplicationName() != null){
	  application.setApplicationName(applicationRequest.getApplicationName());}
	  
	  if(applicationRequest.getDescription() != null){
	  application.setDescription(applicationRequest.getDescription());}
	  
	  if(applicationRequest.getOwner()!= null){
	  application.setOwner(applicationRequest.getOwner());}
	  
	  // Save the entity in JPA repository 
	  Application applicationResponse = applicationRepository.save(application); 
	  ApplicationVO applicationVO = null;
	  if(applicationResponse != null) {
	//  log.info("Application Response, applicationResponse:{}", applicationResponse); // another pojo class it will insert the record
	  applicationVO = new ApplicationVO();
	  applicationVO.setApplicationId(application.getApplicationId());
	  applicationVO.setApplicationName(application.getApplicationName());
	  applicationVO.setOwner(application.getOwner());
	  applicationVO.setDescription(application.getDescription()); } return
	  applicationVO; }
	 
	 /**
		 * Delete by application ID
		 * 
		 * @param id
		 * @return
		 * @throws ApplicationNotFoundException
		 */
			  
			 // @PostAuthorize("returnObject.type == authentication.user") 
			  public String delete(long id) throws ApplicationNotFoundException {
			//  log.info("Input to AppplicationServiceImpl.delete, id:{}", id); 
				  if(id<0){
			//  log.info("Invalid application id"); throw new  ApplicationNotFoundException("Invalid application id"); 
					  } 
					  try {
			  applicationRepository.deleteById(id); 
			  }catch(Exception ex){
			//  log.error("Exception while deleting application"); throw new ApplicationNotFoundException("Exception while deleting application");
				  }
			  return "Application has been deleted"; 
			  }
			  
			/*
			 * @CacheEvict(value = "findByName",allEntries = true) public void
			 * clearFindByNameCache(){
			 * 
			 * }
			 * 
			 * @CacheEvict(value = "findById", allEntries = true) public void
			 * clearFindByIdcCache(){
			 * 
			 * }
			 * 
			 * public void testIntegration() throws Exception { MessageChannel
			 * producingChannel = applicationContext.getBean("producingChannel",
			 * MessageChannel.class);
			 * 
			 * Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC,
			 * SPRING_INTEGRATION_KAFKA_TOPIC);
			 * 
			 * //log.info("sending 10 messages"); for (int i = 0; i < 10; i++) {
			 * GenericMessage<String> message = new
			 * GenericMessage<>("Hello Spring Integration Kafka " + i + "!", headers);
			 * producingChannel.send(message); System.out.println("sent message:" +
			 * message); } countDownLatchHandler.getLatch().await(10000,
			 * TimeUnit.MILLISECONDS); //
			 * assertThat(countDownLatchHandler.getLatch().getCount()).isEqualTo(10); }
			 */
			  
			  	 
}
