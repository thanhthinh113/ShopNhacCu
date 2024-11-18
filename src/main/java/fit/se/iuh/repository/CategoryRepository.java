package fit.se.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.se.iuh.model.Category;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}