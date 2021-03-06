package com.bhuvana.util;




import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.bhuvana.model.CommentDetails;



public class MailUtil {

	private MailUtil() {
	}

	public static void sendSimpleMail(CommentDetails comments) throws EmailException {
		Email email = new SimpleEmail();
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("admin", "admin"));
		email.setDebug(false);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("ashpeekay23@gmail.com");
		email.setSubject("Comment on your article");
		email.setMsg(comments.getCommentUserId().getName() + "" + comments.getCommentText());
		email.addTo(comments.getCommentArticleId().getAuthorId().getEmailid());
		email.setStartTLSEnabled(true);
		email.send();

	}

}

