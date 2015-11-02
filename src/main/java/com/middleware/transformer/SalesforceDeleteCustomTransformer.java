/**
 * 
 */
package com.middleware.transformer;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.middleware.salesforce.pojo.User;

/**
 * @author sumvedshami
 *
 */
public class SalesforceDeleteCustomTransformer extends AbstractMessageTransformer {

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		if (null != message.getPayload()) {
			
			List<User> users = (List<User>) message.getPayload();
			List<String> userIds = new ArrayList<>();
			
			for (User user : users) {
				userIds.add(user.getId());
			}
			
			return userIds;
		}
		
		return null;
	}

}
