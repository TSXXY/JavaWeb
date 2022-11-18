import com.tan.javaweb.dao.impl.FilmDaoImpl;
import com.tan.javaweb.pojo.Film;

import java.util.List;

public class test {
    public static void main(String[] args) {
        FilmDaoImpl filmDao = new FilmDaoImpl();
        List<Film> filmList = filmDao.getFilmList();
        for (Film film : filmList) {
            System.out.println(film);

        }
    }
}
