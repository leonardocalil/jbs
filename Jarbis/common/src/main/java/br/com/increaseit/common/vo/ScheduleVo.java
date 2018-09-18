package br.com.increaseit.common.vo;

public class ScheduleVo extends ModelVo<ScheduleVo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8001663148256013277L;
	protected boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	protected Class<ScheduleVo> getInstance() {
		return ScheduleVo.class;
	}

	
	
}
