/**
 * This file is part of General Entity Annotator Benchmark.
 *
 * General Entity Annotator Benchmark is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * General Entity Annotator Benchmark is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with General Entity Annotator Benchmark.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.gerbil.dataset.impl;

import java.io.IOException;
import java.util.Properties;

import org.aksw.gerbil.annotator.File2SystemEntry;
import org.aksw.gerbil.dataset.Dataset;
import org.aksw.gerbil.utils.ClosePermitionGranter;

public abstract class AbstractDataset implements Dataset {

    protected String name;
    protected ClosePermitionGranter granter;
    protected String qLang;
    private File2SystemEntry entry;
	private String[] additional;  
    
    public AbstractDataset() {
    }

    public AbstractDataset(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setClosePermitionGranter(ClosePermitionGranter granter) {
        this.granter = granter;
    }

    @Override
    public final void close() throws IOException {
        if ((granter == null) || (granter.givePermissionToClose())) {
            performClose();
        }
    }

    
    protected void performClose() throws IOException {
        // nothing to do
    }
    
    public void setQuestionLanguage(String qLang){
    	this.qLang = qLang;
    }
    
    public String getQuestionLanguage(){
    	return qLang;
    }
    
    @Override
    public void setAdditionalProperties(String[] additionalProperties) {
    	this.additional = additionalProperties;
    }
    
    @Override
    public String[] getAdditionalProperties() {
    	return this.additional;
    }
}
