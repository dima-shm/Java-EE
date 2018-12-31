    package servlets;

import com.yandex.disk.client.Credentials;
import com.yandex.disk.client.TransportClient;
import com.yandex.disk.client.exceptions.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "Sss", urlPatterns = "/sss")
public class Sss extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TransportClient client = null;
        Credentials user = new Credentials("login", "password");
        try {
            client = TransportClient.getInstance(user);
        } catch (WebdavClientInitException e) {
            e.printStackTrace();
        }
        if (req.getParameter("type").equals("mkdir")) {
            try {
                client.makeFolder("Hello");
            } catch (DuplicateFolderException e) {
                e.printStackTrace();
            } catch (IntermediateFolderNotExistException e) {
                e.printStackTrace();
            } catch (WebdavUserNotInitialized webdavUserNotInitialized) {
                webdavUserNotInitialized.printStackTrace();
            } catch (PreconditionFailedException e) {
                e.printStackTrace();
            } catch (WebdavNotAuthorizedException e) {
                e.printStackTrace();
            } catch (ServerWebdavException e) {
                e.printStackTrace();
            } catch (UnsupportedMediaTypeException e) {
                e.printStackTrace();
            } catch (UnknownServerWebdavException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("type").equals("rmdir")) {
            try {
                client.delete("Hello");
            } catch (WebdavFileNotFoundException e) {
                e.printStackTrace();
            } catch (WebdavUserNotInitialized webdavUserNotInitialized) {
                webdavUserNotInitialized.printStackTrace();
            } catch (UnknownServerWebdavException e) {
                e.printStackTrace();
            } catch (PreconditionFailedException e) {
                e.printStackTrace();
            } catch (WebdavNotAuthorizedException e) {
                e.printStackTrace();
            } catch (ServerWebdavException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("type").equals("upload")) {
            try {
                try {
                    client = TransportClient.getUploadInstance(user);
                } catch (WebdavClientInitException e) {
                    e.printStackTrace();
                }
                client.uploadFile("C:\\hello.txt", "", null);
                try {
                    client.publish("hello.txt");
                } catch (WebdavException e) {
                    e.printStackTrace();
                }
            } catch (UnknownServerWebdavException e) {
                e.printStackTrace();
            } catch (PreconditionFailedException e) {
                e.printStackTrace();
            } catch (IntermediateFolderNotExistException e) {
                e.printStackTrace();
            } catch (WebdavUserNotInitialized webdavUserNotInitialized) {
                webdavUserNotInitialized.printStackTrace();
            } catch (ServerWebdavException e) {
                e.printStackTrace();
            } catch (WebdavNotAuthorizedException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("type").equals("download")) {
            try {
                try {
                    client = TransportClient.getUploadInstance(user);
                } catch (WebdavClientInitException e) {
                    e.printStackTrace();
                }
                client.downloadFile("hello.txt","D:\\hello.txt",null);

            } catch (WebdavUserNotInitialized webdavUserNotInitialized) {
                webdavUserNotInitialized.printStackTrace();
            } catch (PreconditionFailedException e) {
                e.printStackTrace();
            } catch (WebdavNotAuthorizedException e) {
                e.printStackTrace();
            } catch (ServerWebdavException e) {
                e.printStackTrace();
            } catch (CancelledDownloadException e) {
                e.printStackTrace();
            } catch (UnknownServerWebdavException e) {
                e.printStackTrace();
            }
        } else if (req.getParameter("type").equals("copy")) {
            try {
                client.move("1","ellow\\");
            } catch (WebdavException e) {
                e.printStackTrace();
            }
        }


//        String authHeader = req.getHeader("Authorization");
//        resp.getWriter().append(authHeader);
//        if (authHeader != null) {
//            StringTokenizer st = new StringTokenizer(authHeader);
//            if (st.hasMoreTokens()) {
//                String basic = st.nextToken();
//
//                if (basic.equalsIgnoreCase("Basic")) {
//                    try {
//                        String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
//                        //    LOG.debug("Credentials: " + credentials);
//                        int p = credentials.indexOf(":");
//                        if (p != -1) {
//                            String login = credentials.substring(0, p).trim();
//                            String password = credentials.substring(p + 1).trim();
//                            Credentials user = new Credentials(login, password);
//                            resp.getWriter().append(login + ":" + password);
//                            try {
//                                TransportClient client = null;
//                                try {
//                                    client = TransportClient.getInstance(user);
//                                } catch (WebdavClientInitException e) {
//                                    e.printStackTrace();
//                                }
//
//                                if (req.getParameter("type").equals("createfolder")) {
//                                    try {
//                                        try {
//                                            client.delete("Hello");
//                                        } catch (WebdavUserNotInitialized webdavUserNotInitialized) {
//                                            webdavUserNotInitialized.printStackTrace();
//                                        } catch (UnknownServerWebdavException e) {
//                                            e.printStackTrace();
//                                        } catch (PreconditionFailedException e) {
//                                            e.printStackTrace();
//                                        } catch (WebdavNotAuthorizedException e) {
//                                            e.printStackTrace();
//                                        } catch (ServerWebdavException e) {
//                                            e.printStackTrace();
//                                        }
//                                    } catch (WebdavFileNotFoundException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                }
//
//            }
//        }
    }
}