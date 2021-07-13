package com.spring.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.common.BaseRepository;
import com.spring.jdbc.entitiy.Student;

@Repository
public class StudentRepositoryImpl extends BaseRepository<Student> implements StudentRepository{
	
	
	private final String INSERT_STUDENT_QUERY="insert into student_Data  (id,name,age)  values (:id,:name,:age)";
	
	private final String SELECT_STUDENT_BY_ID ="SELECT * FROM student_Data  where id =:id";
	private final String SELECT_STUDENT="SELECT * FROM student_Data  ";
	
	private final String DELETE_STUDENT_BY_ID ="delete from student_Data  where id =:id";

	@Override
	public List<Student> findAll() {
		
		return getNamedParameterJdbcTemplate().query("SELECT * FROM student_Data ", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				
				return s;
			}
		});
		 
	}

	@Override
	public Student findById(Integer id) {
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		
		Student student = getNamedParameterJdbcTemplate().queryForObject(SELECT_STUDENT_BY_ID, paramMap, BeanPropertyRowMapper.newInstance(Student.class));
		
		return student;
	}

	@Override
	public Integer delete(Integer id) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);

		 int update = getNamedParameterJdbcTemplate().update(DELETE_STUDENT_BY_ID, paramMap);
		 
		 return update;

	}

	@Override
	public Student saveStudent(Student student) {
		
		
		
		Map<String, Object> map= new HashMap<>();
		map.put("id", student.getId());
		map.put("name", student.getName());
		map.put("age", student.getAge());
		
		
		int id = getNamedParameterJdbcTemplate().update(INSERT_STUDENT_QUERY, map);
		student.setId(id);
		return student;
	}

	@Override
	public Student getStudentById(Integer id) {
	
		MapSqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		
		Student student = getNamedParameterJdbcTemplate().queryForObject(SELECT_STUDENT_BY_ID, paramMap, BeanPropertyRowMapper.newInstance(Student.class));
		
		return student;
	}

	@Override
	public List<Student> getList() {
		return getNamedParameterJdbcTemplate().query(SELECT_STUDENT, new RowMapper<Student>() {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

			Student s = new Student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setAge(rs.getInt("age"));
			
			return s;
		}
	});
	}

}
