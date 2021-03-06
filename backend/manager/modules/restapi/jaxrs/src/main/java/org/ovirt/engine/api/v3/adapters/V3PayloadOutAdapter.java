/*
Copyright (c) 2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.api.v3.adapters;

import static org.ovirt.engine.api.v3.adapters.V3OutAdapters.adaptOut;

import org.ovirt.engine.api.model.Payload;
import org.ovirt.engine.api.v3.V3Adapter;
import org.ovirt.engine.api.v3.types.V3Files;
import org.ovirt.engine.api.v3.types.V3Payload;

public class V3PayloadOutAdapter implements V3Adapter<Payload, V3Payload> {
    @Override
    public V3Payload adapt(Payload from) {
        V3Payload to = new V3Payload();
        if (from.isSetFiles()) {
            to.setFiles(new V3Files());
            to.getFiles().getFiles().addAll(adaptOut(from.getFiles().getFiles()));
        }
        if (from.isSetType()) {
            to.setType(from.getType());
        }
        if (from.isSetVolumeId()) {
            to.setVolumeId(from.getVolumeId());
        }
        return to;
    }
}
