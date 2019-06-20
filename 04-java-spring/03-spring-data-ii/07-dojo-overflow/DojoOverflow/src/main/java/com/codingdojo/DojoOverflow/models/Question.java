package com.codingdojo.DojoOverflow.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//this is a one pointing toward Many Answers
//so like dojos to ninjas

//This is a Many pointing toward Many tags through join table TagsQuestions, so like products pointed to Categories through categories_products

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String question;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable (
		name = "tags_questions",
		joinColumns = @JoinColumn(name = "question_id"),
    	inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Size(max=3)  //this is for a particular question
    
    //will have list of tags for each question and a list of answers for each question
    private List<Tag> tags;

	public Question() {
		this.tags=new ArrayList<Tag>();
	}
	
	
	//loop through to convert list to string
	public String listToString() {
		String result ="";

//		for(Tag oneTag: tags) {
		for(int i=0; i<tags.size();i++) {
		result +=tags.get(i).getSubject();
			if(i<tags.size()-1) {
				result += ", ";
			}
			System.out.println(result);
		}
		return result;
	}
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getQuestion() {
		return question;
	}




	public void setQuestion(String question) {
		this.question = question;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public List<Answer> getAnswers() {
		return answers;
	}




	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}




	public List<Tag> getTags() {
		return tags;
	}




	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}




	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	

} // end of QuestionRepository class


/*
Fields with notes
id

question

created_at

updated_at









*/