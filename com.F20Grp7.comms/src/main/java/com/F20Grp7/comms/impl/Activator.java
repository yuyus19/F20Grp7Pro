package com.F20Grp7.comms.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */
public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("LightUp registering");
		
		bundleContext.registerService(SwingProgramNodeService.class, new RobComProgramNodeService(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}


}

