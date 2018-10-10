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

package co.cask.hydrator.format.input.parquet;

import co.cask.cdap.api.annotation.Description;
import co.cask.cdap.api.annotation.Name;
import co.cask.cdap.api.annotation.Plugin;
import co.cask.cdap.api.data.schema.Schema;
import co.cask.hydrator.format.input.InputFormatConfig;
import co.cask.hydrator.format.input.PathTrackingInputFormatProvider;

import java.util.Map;

/**
 * Provides and sets up configuration for an parquet input format.
 */
@Plugin(type = "inputformat")
@Name("parquet")
@Description("Parquet input format plugin for file based plugins.")
public class ParquetInputFormatProvider extends PathTrackingInputFormatProvider<InputFormatConfig> {

  public ParquetInputFormatProvider(InputFormatConfig conf) {
    super(conf);
  }

  @Override
  public String getInputFormatClassName() {
    return CombineParquetInputFormat.class.getName();
  }

  @Override
  protected void addFormatProperties(Map<String, String> properties) {
    Schema schema = conf.getSchema();
    if (schema != null) {
      properties.put("parquet.avro.schema", schema.toString());
    }
  }
}
