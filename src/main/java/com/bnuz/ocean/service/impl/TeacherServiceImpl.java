//package com.bnuz.ocean.service.impl;
//
//import com.bnuz.ocean.entity.Teacher;
//import com.bnuz.ocean.repository.TeacherRepository;
//import com.bnuz.ocean.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Configuration
//public class TeacherServiceImpl implements TeacherService, UserDetailsService {
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Teacher teacher = teacherRepository.findAllByTeacherName(username);
//        teacher.setTeacherPassword(this.passwordEncoder.encode(teacher.getTeacherPassword()));
//
//        return new User(username,
//                teacher.getTeacherPassword(),
//                true,
//                true,
//                true,
//                true,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//}
