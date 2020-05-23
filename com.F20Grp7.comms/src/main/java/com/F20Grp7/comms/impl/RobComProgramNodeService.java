package com.F20Grp7.comms.impl;


import java.util.Locale;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;



	public class RobComProgramNodeService implements SwingProgramNodeService<RobComProgramNodeContribution, RobComProgramNodeView>{
		
		@Override
		public String getId() {
			return "RobComNode";
		}
		
		@Override
		public void configureContribution(ContributionConfiguration configuration) {
			configuration.setChildrenAllowed(false);
		}
		
		@Override
		public String getTitle(Locale locale) {
			return "Robot Comms";
		}	

		@Override
		public RobComProgramNodeView createView(ViewAPIProvider apiProvider) {
			return new RobComProgramNodeView(apiProvider);
		}

		@Override
		public RobComProgramNodeContribution createNode(ProgramAPIProvider apiProvider, RobComProgramNodeView view, DataModel model, CreationContext context) {
			return new RobComProgramNodeContribution(apiProvider, view, model);
		}

	}