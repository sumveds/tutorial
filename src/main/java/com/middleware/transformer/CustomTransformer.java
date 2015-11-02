/**
 * 
 */
package com.middleware.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.streaming.ConsumerIterator;
import org.mule.transformer.AbstractMessageTransformer;

import com.middleware.salesforce.pojo.User;

/**
 * @author sumvedshami
 *
 */
public class CustomTransformer extends AbstractMessageTransformer {

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		if (null != message.getPayload()) {
			
			ConsumerIterator<Map<String, String>> itr = (ConsumerIterator<Map<String, String>>) message.getPayload();
			
			List<User> users = new ArrayList<User>();
			
			while (itr.hasNext()) {
				
				Map<String, String> map = itr.next();
				
				User user = new User(map.get("Id"));
				user.setActive(map.get("IsActive"));
				user.setName(map.get("Name"));
				user.setProfileId(map.get("ProfileId"));
				
				users.add(user);
			}
			
			message.setPayload(users);
			
			return users;
		}
		
		return null;
	}

}
