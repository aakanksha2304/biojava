package org.biojava.bio.structure.align.ce;

import org.biojava.bio.structure.align.StructureAlignment;
import org.biojava.bio.structure.align.util.ConfigurationException;


public class CeSideChainMain  extends CeMain implements StructureAlignment {

	public static final String algorithmName = "jCE-sidechain";

	/**
	 *  version history:
	 *  2.4 - Added more parameters to the command line, including -maxOptRMSD
	 *  2.3 - Initial version
	 */
	private static final String version = "2.3";

	public CeSideChainMain(){
		super();

		if ( params == null) {
			CeSideChainUserArgumentProcessor proc = new CeSideChainUserArgumentProcessor();
			params = (CeParameters) proc.getParameters();
		}
	}

	public static void main(String[] args) throws ConfigurationException {
		CeSideChainUserArgumentProcessor processor = new CeSideChainUserArgumentProcessor();
		processor.process(args);
	}

	@Override
	public String getAlgorithmName() {

		return algorithmName;
	}

	@Override
	public ConfigStrucAligParams getParameters() {

		return params;
	}

	@Override
	public void setParameters(ConfigStrucAligParams params){
		System.out.println("setting params : " + params);
		if (! (params instanceof CeParameters )){
			throw new IllegalArgumentException("provided parameter object is not of type CeParameter");
		}
		this.params = (CeParameters) params;
	}

	@Override
	public String getVersion() {
		return version;
	}

}
