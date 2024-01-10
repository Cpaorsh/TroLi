//package com.newspage.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
// 
//import com.newspage.beans.Doc;
//import com.newspage.dao.DocDao;
// 
//@Controller
//
//public class MainRESTController {
// 
// @Autowired
// DocDao pageJson;
// 
// @RequestMapping(value = "/pageJson", method = RequestMethod.GET)
// @ResponseBody
// public List<Doc> listEmployee() {
//  return pageJson.getDocs();
// }
// 
// @RequestMapping(value = "/pageJson/search/{name}", method = RequestMethod.GET)
// @ResponseBody
// public List<Doc> listSearch(@PathVariable String name) {
//  return pageJson.findDocs(name);
// }
// 
// @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.GET)
// @ResponseBody
// public Doc findEmployee(@PathVariable("id") int docId) {
//  return pageJson.getDocById(docId);
// }
// 
// @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.POST)
// @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
// public String saveEmployee(@PathVariable("id") Doc docId) throws Exception {
//  pageJson.save(docId);
//  return "redirect:/pageJson/" + docId;
// }
// 
// @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.PUT)
// @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
// public String updateEmployee(@PathVariable("id") Doc docId) throws Exception {
//  pageJson.update(docId);
//  return "redirect:/pageJson/" + docId;
// }
// 
// @RequestMapping(value = "/pageJson/{id}", method = RequestMethod.DELETE)
// @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
// @ResponseBody
// public String deleteEmployee(@PathVariable("id") int docId) throws Exception {
//  pageJson.delete(docId);
//  return "OK";
// }
// 
//}

