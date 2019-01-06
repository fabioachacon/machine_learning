import tensorflow as tf
import matplotlib.pyplot as plt
from tensorflow.python.keras.callbacks import ModelCheckpoint, EarlyStopping


#Author Fábio Chacon

mnist = tf.keras.datasets.mnist

(train_data, train_labels), (test_data, test_labels) = mnist.load_data()

'''Reshape a rank-3 tensor into a rank-2 tensor. 
This results in a design matrix with 60000 rows (examples) and 784 columns (features).'''
train_data = train_data.reshape((60000, 28 * 28))
'''Divides every pixel in the image by 255.
 The pixels values will be restricted to the bounded interval [0,1]'''
train_data = train_data.astype('float32') / 255

test_data = test_data.reshape((10000, 28 * 28))
test_data = test_data.astype('float32') / 255

train_labels = tf.keras.utils.to_categorical(train_labels)
test_labels = tf.keras.utils.to_categorical(test_labels)

x_val = train_data[:1000]
partial_x_train = train_data[1000:]

y_val = train_labels[:1000]
partial_y_train = train_labels[1000:]


def densely_connected_layers():
       return tf.keras.models.Sequential([
        tf.keras.layers.Dense(512, activation='relu'),
        tf.keras.layers.Dropout(0.2),
        tf.keras.layers.Dense(10, activation='softmax')])

def convolutional_layers():
    return tf.keras.models.Sequential([
        tf.keras.layers.Conv2D(32, (5, 5), activation='relu', input_shape=(28, 28, 1)),
        tf.keras.layers.MaxPooling2D((2, 2)),
        tf.keras.layers.Conv2D(64, (1, 1), activation='relu'),
        tf.keras.layers.Flatten(),
        tf.keras.layers.Dense(512, activation='relu'),
        tf.keras.layers.Dense(10, activation='softmax')
    ])

callback_list = [EarlyStopping(
                       monitor='acc',
                       patience=1
                 ),
                 ModelCheckpoint(
                     filepath='my_model.h5',
                     monitor='val_loss',
                     save_best_only=True
                  )
                 ]

dense = densely_connected_layers()
#convolutional = convolutional_layers()

dense.compile(optimizer=tf.keras.optimizers.Adam(0.001),
              loss='categorical_crossentropy',
              metrics=['accuracy'])

history = dense.fit(partial_x_train,
                    partial_y_train,
                    epochs=12,
                    batch_size=128,
                    validation_data=(x_val, y_val))


loss = history.history['loss']
val_loss = history.history['val_loss']
epochs = range(1, len(loss) + 1)

plt.plot(epochs, loss, 'bo', label='Training loss')
plt.plot(epochs, val_loss, 'b', label='Validation loss')
plt.title('Training and Validation Loss')
plt.xlabel('Epochs')
plt.ylabel('Loss')
plt.legend()

plt.show()
plt.clf()

acc = history.history['acc']
val_acc = history.history['val_acc']

plt.plot(epochs, acc, 'bo', label='Training acc')
plt.plot(epochs, val_acc, 'b', label='Validation acc')
plt.title('Training and Validation Acc')
plt.ylabel('Loss')
plt.xlabel('Epochs')
plt.legend()

plt.show()
plt.clf()

test_loss, test_acc = dense.evaluate(test_data, test_labels)
print('test acc: ', test_acc)