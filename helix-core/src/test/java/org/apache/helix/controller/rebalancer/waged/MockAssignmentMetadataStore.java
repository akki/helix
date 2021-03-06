package org.apache.helix.controller.rebalancer.waged;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Collections;
import java.util.Map;

import org.apache.helix.BucketDataAccessor;
import org.apache.helix.model.ResourceAssignment;
import org.mockito.Mockito;

/**
 * A mock up metadata store for unit test.
 * This mock datastore persist assignments in memory only.
 */
public class MockAssignmentMetadataStore extends AssignmentMetadataStore {
  MockAssignmentMetadataStore() {
    super(Mockito.mock(BucketDataAccessor.class), "");
  }

  public Map<String, ResourceAssignment> getBaseline() {
    return _globalBaseline == null ? Collections.emptyMap() : _globalBaseline;
  }

  public boolean persistBaseline(Map<String, ResourceAssignment> globalBaseline) {
    _globalBaseline = globalBaseline;
    return true;
  }

  public Map<String, ResourceAssignment> getBestPossibleAssignment() {
    return _bestPossibleAssignment == null ? Collections.emptyMap() : _bestPossibleAssignment;
  }

  public boolean persistBestPossibleAssignment(
      Map<String, ResourceAssignment> bestPossibleAssignment) {
    _bestPossibleAssignment = bestPossibleAssignment;
    return true;
  }

  public void close() {
    // do nothing
  }
}
