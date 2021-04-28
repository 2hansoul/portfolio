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
      //////////////////////// 메일(네이버메일) 세팅
      String host = "smtp.naver.com";
      final String user = "2hansoul@naver.com"; // 관리자 아이디
      final String password = "adda7494*0"; // 관리자 비밀번호

      //////////////////////////////////// 받는사람설정
      String to = "2hansoul@naver.com";

      // 연결세션정보
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
      // 메세지내용구성
      try {
         MimeMessage message = new MimeMessage(session);  // 보내는 정보(주소지(ip))
            message.setFrom( new InternetAddress(user)); // 보내는 사람설정
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 받는사람설정
            //내용구성
            message.setSubject(subject);
            message.setContent("<p>"+content+"</p>","text/html;charset=euc-kr"); //메일보낼시 한글깨짐 인코딩설정
            Transport.send(message);
            response.sendRedirect(request.getContextPath()+"/viewpage/mail.jsp");
            System.out.println("메일"+to);
            System.out.println("메일subject"+subject);
            System.out.println("메일result"+result);
            
            if(result<1) {
          		out.println("<script>alert('메일보내기성공'); location.href='"+request.getContextPath()+"/list.do';</script>");
             }else {
          	   out.println("<script>alert('비빌번호 확긴'); history.go(-1);</script>");
             } 
      } catch (Exception e) {
         e.printStackTrace();
      }
    
      
   }

}