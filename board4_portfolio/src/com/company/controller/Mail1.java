package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Mail1
 */
@WebServlet("/Mail1")
public class Mail1 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public Mail1() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out=response.getWriter();
      String subject = request.getParameter("subject");
      String content = request.getParameter("content");
      int result=1;
      //////////////////////// ����(���̹�����) ����
      String host = "smtp.naver.com";
      final String user = "2hansoul@naver.com"; // ������ ���̵�
      final String password = "adda7494*0"; // ������ ��й�ȣ

      //////////////////////////////////// �޴»������
      String to = "2hansoul@naver.com";

      // ���Ἴ������
      Properties props = new Properties(); // java.util.Properties
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.post", "465");
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.ssl.trust", "smtp.naver.com");

   
      
      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
         }
      });
      // �޼������뱸��
      try {
         MimeMessage message = new MimeMessage(session);  // ������ ����(�ּ���(ip))
            message.setFrom( new InternetAddress(user)); // ������ �������
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // �޴»������
            //���뱸��
            message.setSubject(subject);
            message.setContent("<p>"+content+"</p>","text/html;charset=euc-kr"); //���Ϻ����� �ѱ۱��� ���ڵ�����
            Transport.send(message);
            response.sendRedirect(request.getContextPath()+"/viewpage/mail.jsp");
            System.out.println("����"+to);
            System.out.println("����subject"+subject);
            System.out.println("����result"+result);
            
            if(result<1) {
          		out.println("<script>alert('���Ϻ����⼺��'); location.href='"+request.getContextPath()+"/list.do';</script>");
             }else {
          	   out.println("<script>alert('�����ȣ Ȯ��'); history.go(-1);</script>");
             } 
      } catch (Exception e) {
         e.printStackTrace();
      }
    
      
   }

}