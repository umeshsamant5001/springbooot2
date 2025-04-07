package com.swscode.order.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.swscode.order.entity.Sequence;

@Service
public class SequenceGenerator {
	
	@Autowired
	MongoOperations mongoOperations;
	
	
	public Long generateNextOrderId() {
		
		//FindAndModifyOptions options = new FindAndModifyOptions();
		System.out.println("inside generateNextOrderId ");
		Sequence counter = mongoOperations.findAndModify(
				query(where("_id").is("sequence")),
				new Update().inc("seq", 1), 
				options().returnNew(true).upsert(true),
				Sequence.class );
				
			//	query(where("_id").is("sequence")),
            //    new Update().inc("seq",1) , options().returnNew(true).upsert(true),
            //    Sequence.class
			//	);
		
		System.out.println("counter.getSeq() " + counter.getSeq() );
		return !Objects.isNull(counter) ? counter.getSeq() : 1;//counter.getSequence();
	}


//	private Object where(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	private Object options() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
