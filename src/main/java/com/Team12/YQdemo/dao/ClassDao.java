package com.Team12.YQdemo.dao;

import com.Team12.YQdemo.bean.Uclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassDao extends JpaRepository<Uclass, Long> {
    Uclass findByUid(long uid);
    List<Uclass> findAllByUmajorAndGradeAndUclass(String umajor, String grade, String uclass);
    Uclass findByUmajorAndGradeAndUclassAndUid(String umajor, String grade, String uclass, long uid);

    void deleteByUmajorAndGradeAndUclassAndSno(String umajor , String grade , String uclass , String sno);
}