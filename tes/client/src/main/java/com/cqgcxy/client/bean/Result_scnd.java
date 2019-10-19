package com.cqgcxy.client.bean;

 public class Result_scnd {
   private int id;
   private  int tid;
   private int sid;
   private String total;

  @Override
  public String toString() {
   return "Result_scnd{" +
           "id=" + id +
           ", tid=" + tid +
           ", sid=" + sid +
           ", total='" + total + '\'' +
           '}';
  }

  public int getId() {
   return id;
  }

  public void setId(int id) {
   this.id = id;
  }

  public int getTid() {
   return tid;
  }

  public void setTid(int tid) {
   this.tid = tid;
  }

  public int getSid() {
   return sid;
  }

  public void setSid(int sid) {
   this.sid = sid;
  }

  public String getTotal() {
   return total;
  }

  public void setTotal(String total) {
   this.total = total;
  }
 }
