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

package co.cask.hydrator.format.input;

import co.cask.cdap.api.data.batch.InputFormatProvider;
import co.cask.cdap.api.data.schema.Schema;

import java.util.Map;
import javax.annotation.Nullable;

/**
 * Creates FileInputFormatters.
 */
public interface FileInputFormatterProvider {

  /**
   * Get the schema that the format requires, if it requires a specific schema.
   */
  @Nullable
  Schema getSchema(@Nullable String pathField);

  /**
   * Creates a InputFormatProvider.
   */
  InputFormatProvider create(Map<String, String> properties, @Nullable Schema schema);
}
