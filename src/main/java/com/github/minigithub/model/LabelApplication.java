package com.github.minigithub.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.minigithub.dto.LabelApplicationDTO;
import com.github.minigithub.dto.LabelDTO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name = "labelApplications")
public class LabelApplication extends Event implements Serializable {

   @OneToMany(mappedBy = "labelApplication")
   public Collection<Label> labels;

   public LabelApplication(Long id, Date dateTime, Task task) {
      super(id, dateTime, task);
   }

   public LabelApplication(Long id, Date dateTime, Task task, Collection<Label> labels) {
      super(id, dateTime, task);
      this.labels = labels;
   }

   public LabelApplication(LabelApplicationDTO labelApplication) {
      super(labelApplication.getId(), labelApplication.getDateTime(), new Task(labelApplication.getTask());

      Collection<Label> labels;
      for (LabelDTO label : labelApplication.getLabels()) {
         labels.add(new Label(label));
      }
		this.labels = labels;
	}

   public Collection<Label> getLabel() {
      if (labels == null)
         labels = new HashSet<Label>();
      return labels;
   }

   public Iterator getIteratorLabel() {
      if (labels == null)
         labels = new HashSet<Label>();
      return labels.iterator();
   }

   public void setLabel(Collection<Label> newLabel) {
      removeAllLabel();
      for (Iterator iter = newLabel.iterator(); iter.hasNext();)
         addLabel((Label) iter.next());
   }

   public void addLabel(Label newLabel) {
      if (newLabel == null)
         return;
      if (this.labels == null)
         this.labels = new HashSet<Label>();
      if (!this.labels.contains(newLabel))
         this.labels.add(newLabel);
   }

   public void removeLabel(Label oldLabel) {
      if (oldLabel == null)
         return;
      if (this.labels != null)
         if (this.labels.contains(oldLabel))
            this.labels.remove(oldLabel);
   }

   public void removeAllLabel() {
      if (labels != null)
         labels.clear();
   }
}