package com.Team12.YQdemo.repository数据访问层包或叫dao包;

import com.Team12.YQdemo.domain实体类包.uClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassDao extends JpaRepository<uClass, Long> {
    uClass findByUid(long uid);
    List<uClass> findAllByUmajorAndGradeAndUclass(String umajor, String grade, String uclass);
    uClass findByUmajorAndGradeAndUclassAndUid(String umajor, String grade, String uclass,long uid);
    uClass findBySno(String sno);
}