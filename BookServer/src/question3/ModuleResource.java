package question3;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/modules")
public class ModuleResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Module>getModules(){
		return ModuleDao.INSTANCE.getModules();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{moduleId}")
	public Module getModule(@PathParam("moduleId") String id){
		return ModuleDao.INSTANCE.getModule(Integer.parseInt(id));
	}
}
