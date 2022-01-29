package com.github.minigithub.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Entity
@Table(name = "labelApplications")
public class LabelApplication extends Event implements Serializable {

   @OneToMany(mappedBy = "labelApplication")
   public Collection<Label> labels;

   public LabelApplication(Collection<Label> labels) {
      super();
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