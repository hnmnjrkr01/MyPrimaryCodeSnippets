package com.sprint1.plantnursery.service;

import java.util.List;
import com.sprint1.plantnursery.entity.Planter;

/*Controller Class for Planter Controller
Created By: Pruthvi Tilwankar
*/

public interface IPlanterService {
	public Planter addPlanter(Planter planter);
	public Planter updatePlanter(Planter planter);
	public Planter deletePlanter(int planterId);
	public Planter getPlanter(int planterId);
	public List<Planter> viewAllPlanters();
	public List<Planter> viewAllPlanters(double minCost,double maxCost);

}
