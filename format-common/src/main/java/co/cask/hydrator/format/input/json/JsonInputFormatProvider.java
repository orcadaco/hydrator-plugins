/*
 * Copyright © 2018 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.hydrator.format.input.json;

import co.cask.cdap.api.annotation.Description;
import co.cask.cdap.api.annotation.Name;
import co.cask.cdap.api.annotation.Plugin;
import co.cask.hydrator.format.input.InputFormatConfig;
import co.cask.hydrator.format.input.PathTrackingInputFormatProvider;

/**
 * Reads json into StructuredRecords.
 */
@Plugin(type = "inputformat")
@Name("json")
@Description("Json input format plugin for file based plugins.")
public class JsonInputFormatProvider extends PathTrackingInputFormatProvider<InputFormatConfig> {

  public JsonInputFormatProvider(InputFormatConfig conf) {
    super(conf);
  }

  @Override
  public String getInputFormatClassName() {
    return CombineJsonInputFormat.class.getName();
  }

  @Override
  protected void validate() {
    if (conf.getSchema() == null) {
      throw new IllegalArgumentException("Json format cannot be used without specifying a schema.");
    }
  }
}
