package model2_shop.com.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2_shop.com.dao.ItemCommentDao;
import model2_shop.com.dao.ItemDao;
import model2_shop.com.vo.ItemVo;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/item/ajax.do")
public class ItemAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean insert=false;
		boolean fileUp=true;
		String savePath=request.getServletContext().getRealPath("public/img");
		int maxSize=1024*1024*1;
		MultipartRequest multiReq=null;
		File mainImgFile=null;
		File detailImgFile=null;
		try {
			multiReq=new MultipartRequest(request, savePath,maxSize,"UTF-8",(FileRenamePolicy) new FileRenamePolicy() {

				@Override
				public File rename(File f) {
					String ext=f.getName().substring(f.getName().lastIndexOf("."));
					String newFileName="item_"+System.currentTimeMillis()+"_"+(int)(Math.random()*10000)+ext;
					return new File(f.getParent(),newFileName); //원본에 파일이름만 바꿔서 새 파일을 만드는것
				}
				
			});
			mainImgFile=multiReq.getFile("main_img");
			detailImgFile=multiReq.getFile("detail_img");
			String mainImgType=multiReq.getContentType("main_img").split("/")[0]; //"image/jpeg" =>image
			String detailImgType=multiReq.getContentType("detail_img").split("/")[0];
			String mainImgExt=multiReq.getContentType("main_img").split("/")[1]; //"image/jpeg" =>jpeg
			String detailImgExt=multiReq.getContentType("detail_img").split("/")[1];
			if(mainImgType.equals("image") && detailImgType.equals("image")) {
				BufferedImage mainImg=ImageIO.read(mainImgFile);
				BufferedImage mainImgThumb=new BufferedImage(150, 150, BufferedImage.TYPE_3BYTE_BGR);
				mainImgThumb.getGraphics().drawImage(mainImg, 0, 0, 150, 150, null);
				ImageIO.write(mainImgThumb, mainImgExt, new File(savePath+"/thumb/"+mainImgFile.getName()));
			}else {
				fileUp=false;
				mainImgFile.delete();
				detailImgFile.delete();
			}
		}catch (Exception e) {
			fileUp=false;
			e.printStackTrace();
		}
		if(fileUp) {
			ItemVo itemVo=new ItemVo();
			itemVo.setCate_num(Integer.parseInt(multiReq.getParameter("cate_num")));
			itemVo.setCount(Integer.parseInt(multiReq.getParameter("count") ));
			itemVo.setPrice(Integer.parseInt(multiReq.getParameter("price")));
			itemVo.setState(Byte.parseByte(multiReq.getParameter("state")));
			itemVo.setColor(multiReq.getParameter("color"));
			itemVo.setMain_img(mainImgFile.getName());
			itemVo.setDetail_img(detailImgFile.getName());
			itemVo.setMember_id(multiReq.getParameter("member_id"));
			itemVo.setModel_num(multiReq.getParameter("model_num"));
			itemVo.setName(multiReq.getParameter("name"));
			itemVo.setTitle(multiReq.getParameter("title"));
			
			ItemDao itemDao=new ItemDao();
			try {
				insert=itemDao.insert(itemVo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		response.getWriter().append("{\"insert\":"+insert+"}");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item_num=request.getParameter("item_num");
		
		ItemDao itemDao=new ItemDao();
		response.setContentType("application/json; charset=UTF-8;");
		try {
			if(item_num==null) {
				response.getWriter().append(itemDao.list(0).toString());				
			}else {
				response.getWriter().append(itemDao.detail(Integer.parseInt(item_num)).toString());
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json_str="";
		BufferedReader br=request.getReader();
		String line="";
		while((line=br.readLine())!=null) {
			json_str+=line; 
		}
		JSONObject json=new JSONObject(json_str);
		ItemVo item=new ItemVo();
		item.setItem_num(Integer.parseInt( json.getString("item_num") ));
		item.setCate_num(Integer.parseInt( json.getString("cate_num") ));
		item.setCount(Integer.parseInt( json.getString("count") ));
		item.setPrice(Integer.parseInt( json.getString("price")));
		item.setState(Byte.parseByte(json.getString("state")));
		item.setColor(json.getString("color"));
		item.setDetail_img(json.getString("detail_img"));
		item.setMain_img(json.getString("main_img"));
		item.setMember_id(json.getString("member_id"));
		item.setModel_num(json.getString("model_num"));
		item.setName(json.getString("name"));
		item.setTitle(json.getString("title"));
		

		Timestamp saleTime=(json.getString("sale_time")!="")?Timestamp.valueOf(json.getString("sale_time")):null;
		item.setSale_time(saleTime);
		Timestamp saleEndTime=(json.getString("sale_end_time")!="")?Timestamp.valueOf(json.getString("sale_end_time")):null;
		item.setSale_end_time(saleEndTime);
		
		System.out.println("item="+item);
		boolean update=false;
		ItemDao itemDao=new ItemDao();
		try {
			update=itemDao.update(item);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		response.getWriter().append("{\"update\":"+update+"}");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item_num_str=request.getParameter("item_num");
		System.out.println("delete 방식으로 통신 item_num:"+item_num_str);
		boolean delete=false;
		int comment_delete=0;
		ItemDao itemDao=new ItemDao();
		ItemCommentDao itemCommentDao=new ItemCommentDao();
		try {
			int item_num=Integer.parseInt(item_num_str);
			comment_delete=itemCommentDao.deleteItemNum(item_num);
			delete=itemDao.delete(item_num);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		HashMap<String, Object> delMap=new HashMap<>();
		delMap.put("delete",delete);
		delMap.put("comment_delete",comment_delete);
		System.out.println(new JSONObject(delMap).toString());
		response.getWriter().append(new JSONObject(delMap).toString());
	}

}
