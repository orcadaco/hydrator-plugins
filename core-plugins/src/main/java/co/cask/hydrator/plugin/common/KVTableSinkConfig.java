/*
 * Copyright © 2016 Cask Data, Inc.
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

package co.cask.hydrator.plugin.common;

import co.cask.cdap.api.annotation.Description;
import co.cask.cdap.api.annotation.Name;
import co.cask.cdap.api.plugin.PluginConfig;

import javax.annotation.Nullable;

/**
 * Config class for KVTableSink
 */
public class KVTableSinkConfig extends PluginConfig {

  private static final String NAME_DESC = "Name of the dataset. If it does not already exist, one will be created.";
  private static final String KEY_FIELD_DESC = "The name of the field to use as the key. Defaults to 'key'.";
  private static final String VALUE_FIELD_DESC = "The name of the field to use as the value. Defaults to 'value'.";

  @Description(NAME_DESC)
  private String name;

  @Name(Properties.KeyValueTable.KEY_FIELD)
  @Description(KEY_FIELD_DESC)
  @Nullable
  private String keyField;

  @Name(Properties.KeyValueTable.VALUE_FIELD)
  @Description(VALUE_FIELD_DESC)
  @Nullable
  private String valueField;

  public KVTableSinkConfig() {
    this(null, Properties.KeyValueTable.DEFAULT_KEY_FIELD, Properties.KeyValueTable.DEFAULT_VALUE_FIELD);
  }

  public KVTableSinkConfig(String name, String keyField, String valueField) {
    this.name = name;
    this.keyField = keyField;
    this.valueField = valueField;
  }

  public String getName() {
    return name;
  }

  public String getKeyField() {
    return keyField;
  }

  public String getValueField() {
    return valueField;
  }
}
