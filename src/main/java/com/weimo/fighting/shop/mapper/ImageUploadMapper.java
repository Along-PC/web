package com.weimo.fighting.shop.mapper;

import com.weimo.fighting.shop.model.ImageUploadBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImageUploadMapper {

    @Insert("insert into uploadImage(image_path,image_time,upload_person) values(#{imagePath},#{uploadTime},#{userName})")
    public void addImage(ImageUploadBean imageUploadBean);

    @Select("select * from uploadImage order by image_id desc limit 9")
    @Results({
            @Result(column = "image_path",property = "imagePath"),
            @Result(column = "image_time",property = "uploadTime"),
            @Result(column = "upload_person",property = "userName")
    })
    public List<ImageUploadBean> getAllImage();
}
