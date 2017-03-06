package cn.edu.svtcc.mybookshop.tools;

import java.util.List;

import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Categories;

public interface IBookDao {
	public List<Books> getBooksByTitle(String title);
	public List<Books> getBooksById(int id);
	public List<Books> getBooksByauthor(String author);
	public List<Books> getBooksBypublishDate();
	public List<Books> getBooksByCategoriesid(int id);
	public List<Categories> getCategories();
}
