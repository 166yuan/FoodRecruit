package com.recruit.model;

public interface InstanceInterface {

	/**去实例化对象，把当前类中需要加载的类传进来
	 * for example:
	 * Team team = teamImpl.getById(1);
	 *因为当前team对象里有leader和experiment两个对象没有加载，如果需要加载，则进行以下操作
	 * team.toInstanceModel(team.getLeader(),team.getExperiment());
	 * 这样，team对象里的leader和experiment两个对象就会被加载进来，但这两个对象里的对象并没有被加载，可以嵌套加载，如
	 * 再加载leader里的classes对象，则
	 * User leader = team.getLeader();
	 * leader.toInstanceModel(leader.getClasses());
	 * 
	 * @param iis model里的对象
	 * @return
	 */
	public InstanceInterface toInstanceModel(InstanceInterface... iis);
	
}
