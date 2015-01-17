package com.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "question", nullable = false, length = 200)
	private String question;

	@Column(name = "answer", nullable = true, length = 45)
	private String answer;

	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	@ForeignKey(name = "FK_options")
	@JoinColumn(name = "options_id", nullable = false, unique = false)
	private Set<Options> options;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<Options> getOptions() {
		return options;
	}

	public void setOptions(Set<Options> options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
