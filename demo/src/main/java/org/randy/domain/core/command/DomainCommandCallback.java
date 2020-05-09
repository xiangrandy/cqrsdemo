package org.randy.domain.core.command;

/**
 * Callback.
 * 
 * @author x00418543
 *
 */
public interface DomainCommandCallback {

	void onSuccess(DomainCommandResult result);

	void onFailure(Throwable t);

}
