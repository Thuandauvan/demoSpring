package com.laptrinhjavaweb.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.laptrinhjavaweb.constant.CommonConstant;
import com.laptrinhjavaweb.model.Product;
import com.laptrinhjavaweb.response.HTTPStatus;
import com.laptrinhjavaweb.response.Response;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService extends AbstractService implements IProductService {

	@Override
	public Response findAll() {
		try {
		    response.setData(productDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
		}
		return response;
	}

	@Override
	public Response save(Product product, MultipartFile img) {
		Session session = null;
		Transaction tran = null;
		
		try {
			Product model = productDAO.save(product);
			String path = CommonConstant.FILE_UPLOAD_LOCATION + img.getOriginalFilename();
			byte[] bytes = img.getBytes();
			Path p = Paths.get(path);
			Files.write(p, bytes);
			session = sessionFactory.openSession();
			tran = session.beginTransaction();
			String hql = "UPDATE product SET image = :image WHERE id = :id";
			NativeQuery<Product> query = session.createNativeQuery(hql, Product.class);
			query.setParameter("image", path);
			query.setParameter("id", model.getId());
			query.executeUpdate();		
			tran.commit();			
			response.setData("id: " + model.getId());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
			tran.rollback();
		} finally {
			session.close();
		}
		
		return response;
	}

	@Override
	public Response update(Product product) {
		try {
		    productDAO.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
		}
		
		return response;
	}

	@Override
	public Response delete(Long[] ids) {
		try {
			for(Long id: ids) {
				Product product = productDAO.findById(id);
				productDAO.delete(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(HTTPStatus.SERVER_ERROR.getCode());
			response.setMessage(HTTPStatus.SERVER_ERROR.getMessage());
		}
		
		return response;
	}
	
}
