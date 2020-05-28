package org.randy.domain.core.command;

/**
 * Callback.
 * 
 * @author xiangyang
 *
 */
public interface DomainCommandCallback {

	void onSuccess(DomainCommandResult result);

	void onFailure(Throwable t);

}
