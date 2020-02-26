package question3;

import java.util.*;

public enum ModuleDao {
	INSTANCE;
	
	private Map<Integer, Module> modulesMap = new HashMap<Integer, Module>();
	
	private ModuleDao() {
		
		Module module1 = new Module();
		module1.setId(1);
		module1.setName("Distributed Systems");
		module1.setLecturer("EG");
		module1.setHoursPerWeek(4);
		
		modulesMap.put(1, module1);
		
		Module module2 = new Module();
		module2.setId(2);
		module2.setName("WebDev");
		module2.setLecturer("EG");
		module2.setHoursPerWeek(2);
		
		modulesMap.put(2, module2);
	}
	
	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>();
		modules.addAll(modulesMap.values());
		return modules;
	}
	
	public Module getModule(int id) {
		return modulesMap.get(id);
	}
}
